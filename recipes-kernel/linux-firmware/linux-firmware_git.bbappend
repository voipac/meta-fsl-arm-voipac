
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGES =+ " ${PN}-iwlwifi-3160-hmw"
PACKAGES =+ " ${PN}-iwlwifi-4965-2"

RDEPENDS_${PN}-iwlwifi-3160-hmw = "${PN}-iwlwifi-license"
RDEPENDS_${PN}-iwlwifi-4965-2 = "${PN}-iwlwifi-license"

FILES_${PN}-iwlwifi-3160-hmw = "/lib/firmware/iwlwifi-3160-13.ucode /lib/firmware/intel/ibt-hw-37.7.10-fw-1.0.1.2d.d.bseq"
FILES_${PN}-iwlwifi-4965-2 = "/lib/firmware/iwlwifi-4965-2.ucode"

PACKAGES =+ " ${PN}-rtl8191se"

RDEPENDS_${PN}-rtl8191se = "${PN}-rtl-license"

FILES_${PN}-rtl8191se = "/lib/firmware/rtlwifi/rtl8192sefw.bin"
