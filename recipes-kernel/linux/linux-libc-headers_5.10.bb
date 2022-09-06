require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

RENESAS_BSP_URL = " \
    git://github.com/AGLExport/linux-bsp.git"
BRANCH = "v5.10.y/rcar-5.1.4-kf"
SRCREV = "52ad87191a085370244e55fea7de19115a88bace"

SRC_URI = "${RENESAS_BSP_URL};branch=${BRANCH};protocol=https"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

S = "${WORKDIR}/git"
