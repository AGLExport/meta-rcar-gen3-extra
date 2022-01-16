FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " wayland-protocols"

SRC_URI:append = " \
    file://0001-waylandws_client-Ensure-that-supported-DMAbuf-format.patch \
    file://0002-waylandws_client-Rename-DRM-device-setup-function.patch \
"
