SUMMARY = "Renesas package group for multimedia"
LICENSE = "CLOSED & MIT"

inherit packagegroup

COMPATIBLE_MACHINE = "(salvator-x|ulcb|ebisu|draak)"

PR = "r0"

inherit packagegroup

PACKAGES = " \
    packagegroup-multimedia-userland \
    packagegroup-multimedia-kernel \
"

RDEPENDS_packagegroup-multimedia-userland = " \
    packagegroup-multimedia-libs \
    omx-user-module \
    alsa-utils \
    alsa-tools \
"

RDEPENDS_packagegroup-multimedia-kernel = " \
    kernel-module-gles \
    kernel-module-mmngr \
    kernel-module-mmngrbuf \
    kernel-module-qos \
    kernel-module-uvcs-drv \
    kernel-module-vsp2driver \
    kernel-module-vspm \
    kernel-module-vspmif \
"
