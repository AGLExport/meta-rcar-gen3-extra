DESCRIPTION = "Linux kernel for the R-Car Generation 3 based board extended"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-yocto.inc

RENESAS_BSP_URL = " \
    git://github.com/AGLExport/linux-bsp.git"
BRANCH = "v5.10.y/rcar-5.1.4-kf-test"
SRCREV = "3f4b0f51e37be048974a33b6b06ad286774366ec"

SRC_URI = "${RENESAS_BSP_URL};nocheckout=1;branch=${BRANCH};protocol=https \
           "

LINUX_VERSION ?= "5.10.117"
PV = "${LINUX_VERSION}+git${SRCPV}"
PR = "r0"

# For generating defconfig
KCONFIG_MODE = "--alldefconfig"
KBUILD_DEFCONFIG = "defconfig_rcarh3m3_reduced"

KERNEL_DEVICETREE_append_h3ulcb = " \
    renesas/r8a77951-ulcb-kf.dtb \
    renesas/r8a779m1-ulcb-kf.dtb \
    ${ULCB_KF_DTBO} \
"

KERNEL_DEVICETREE_append_m3ulcb = " \
    renesas/r8a77960-ulcb-kf.dtb \
    renesas/r8a77961-ulcb-kf.dtb \
    ${ULCB_KF_DTBO} \
"

do_compile_kernelmodules_append () {
    if (grep -q -i -e '^CONFIG_MODULES=y$' ${B}/.config); then
        # 5.10+ kernels have module.lds that we need to copy for external module builds
        if [ -e "${B}/scripts/module.lds" ]; then
            install -Dm 0644 ${B}/scripts/module.lds ${STAGING_KERNEL_BUILDDIR}/scripts/module.lds
        fi
    fi
}
 
do_deploy_append() {
    # Remove the redundant device tree file (<device_tree>-<MACHINE>.dtb) that was created in the deploy directory
    for dtbf in ${KERNEL_DEVICETREE}; do
        dtb=`normalize_dtb "$dtbf"`
        dtb_ext=${dtb##*.}
        dtb_base_name=`basename $dtb .$dtb_ext`
        rm -f $deployDir/$dtb_base_name-${KERNEL_DTB_LINK_NAME}.$dtb_ext
    done
}

# uio_pdrv_genirq configuration
KERNEL_MODULE_AUTOLOAD_append = " uio_pdrv_genirq"
KERNEL_MODULE_PROBECONF_append = " uio_pdrv_genirq"
module_conf_uio_pdrv_genirq_append = ' options uio_pdrv_genirq of_id="generic-uio"'

