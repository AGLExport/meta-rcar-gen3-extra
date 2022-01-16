SUMMARY = "Renesas package group for multimedia"
LICENSE = "CLOSED & MIT"

inherit packagegroup

COMPATIBLE_MACHINE = "(salvator-x|ulcb|ebisu|draak)"

PR = "r0"

inherit packagegroup

PACKAGES = " \
    packagegroup-multimedia-userland \
"

RDEPENDS_packagegroup-multimedia-userland = " \
    packagegroup-multimedia-libs \
    omx-user-module \
    alsa-utils \
    alsa-tools \
"
