SUMMARY = "Video Input Launchers"
DESCRIPTION = "A simple scripts demostrating video inputs."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = " \
	file://hdmi-input \
	file://hdmi-input.desktop \
	file://mipi-input \
	file://mipi-input.desktop \
"

S = "${WORKDIR}"

do_install() {
	mkdir -p ${D}/usr/bin/
	mkdir -p ${D}/usr/share/applications/
	cp ${S}/hdmi-input ${D}/usr/bin/
	chmod +x ${D}/usr/bin/hdmi-input
	cp ${S}/hdmi-input.desktop ${D}/usr/share/applications/
	cp ${S}/mipi-input ${D}/usr/bin/
	cp ${S}/mipi-input.desktop ${D}/usr/share/applications/
	chmod +x ${D}/usr/bin/mipi-input
}

FILES_${PN} = " \
	/usr/bin/* \
	/usr/share/applications/* \
"
