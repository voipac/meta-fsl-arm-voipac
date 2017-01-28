# Copyright (C) 2016 Voipac
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel for for imx6 TinyRex/Rex boards"
DESCRIPTION = "Linux kernel for for imx6 TinyRex/Rex boards. It includes \
support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-2.0.x-imx-rex"
LOCALVERSION = "-yocto"
SRCREV = "3354960cc81ab7fc46cce66fb6c8bca6e3ce1d2e"
KERNEL_SRC ?= "git://github.com/voipac/linux-fslc.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} file://defconfig"

DEFAULT_PREFERENCE = "1"              

COMPATIBLE_MACHINE = "(mx6|imx6-tinyrexlite|imx6-tinyrexbasic|imx6-tinyrexpro|imx6-tinyrexmax|imx6-tinyrexmax4g|imx6-tinyrexultra|imx6-rexbasic|imx6-rexpro|imx6-rexultra)"
