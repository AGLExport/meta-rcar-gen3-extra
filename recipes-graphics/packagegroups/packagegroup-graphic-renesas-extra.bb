SUMMARY = "Renesas package group for graphics"
LICENSE = "CLOSED & MIT"

inherit packagegroup

COMPATIBLE_MACHINE = "(salvator-x|ulcb|ebisu|draak)"

PACKAGES = " \
    packagegroup-weston-compositor \
    packagegroup-qt-compositor \
    packagegroup-graphics-kernel \
"

PR = "r0"

DEPENDS_packagegroup-weston-compositor = "libegl"
RDEPENDS_packagegroup-weston-compositor = " \
    wayland \
    weston \
    weston-examples \
    libdrm-kms \
    libgbm \
    wayland-kms \
    wayland-wsegl \
    gles-user-module \
"

DEPENDS_packagegroup-qt-compositor = "libegl"
RDEPENDS_packagegroup-qt-compositor = " \
    wayland \
    libdrm-kms \
    libgbm \
    wayland-kms \
    wayland-wsegl \
    gles-user-module \
"

RDEPENDS_packagegroup-graphics-kernel = " \
    kernel-module-gles \
"
