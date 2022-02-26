FILESEXTRAPATHS:prepend := "${THISDIR}/linux-renesas-extra:"

SRC_URI:append = " \
    file://0001-Change-clock-settings-for-over-1080i.patch \
    file://0001-Change-display-order-for-drgb-out.patch \
    file://0001-Disable-lvds0.patch \
    file://0001-drm-enable-dumb-buffer-ops-for-render-nodes.patch \
    file://0002-drm-rcar-du-enable-rcar-du-render-node.patch \
    file://lxc.cfg \
    "

KERNEL_CONFIG_FRAGMENTS:append = " \
    ${WORKDIR}/lxc.cfg \
"
