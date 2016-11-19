require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for imx6 TinyRex/Rex boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(imx6-tinyrexlite|imx6-tinyrexbasic|imx6-tinyrexpro|imx6-tinyrexmax|imx6-tinyrexultra|imx6s-tinyrex|imx6dl-tinyrex|imx6q-tinyrex|imx6-rexbasic|imx6-rexpro|imx6-rexultra|imx6dl-rex)"

PROVIDES += "u-boot"

PV = "v2015.04"

SRCBRANCH = "uboot-imx-v2015.04"
SRCREV = "94310b9f809554ad93eefa6bd4de81d25e601f7e"
UBOOT_SRC ?= "git://github.com/voipac/uboot-imx.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
