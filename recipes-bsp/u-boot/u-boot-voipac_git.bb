require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for imx6q/dl/s TinyRex/Rex boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(imx6q-tinyrex|imx6dl-tinyrex|imx6s-tinyrex)"

PROVIDES += "u-boot"

PV = "v2014.10"

SRCBRANCH = "master"
SRCREV = "0f91ba55c3292e5ba9df6f25e90f6467dbe8d1c4"
UBOOT_SRC ?= "git://github.com/voipac/imx6rex_tiny_uboot_v2014_10.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
