
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGES =+ "${PN}-iwlwifi-4965-2"

RDEPENDS_${PN}-iwlwifi-4965-2 = "${PN}-iwlwifi-license"

FILES_${PN}-iwlwifi-4965-2 = "/lib/firmware/iwlwifi-4965-2.ucode"
