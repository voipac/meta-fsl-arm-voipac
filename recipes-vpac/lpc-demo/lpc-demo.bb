SUMMARY = "LPC1347 files"
DESCRIPTION = "Various platfrom files."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = " \
	file://LPC1347-userLED.bin \
	file://lpc21isp \
	file://openrex-isp-handler.sh \
"

S = "${WORKDIR}"

do_install() {
	mkdir -p ${D}/home/root/lpc/
	cp ${S}/LPC1347-userLED.bin ${D}/home/root/lpc/
	mkdir -p ${D}/usr/bin/
	cp ${S}/lpc21isp ${D}/usr/bin/
	cp ${S}/openrex-isp-handler.sh ${D}/usr/bin/
	chmod +x ${D}/usr/bin/lpc21isp
	chmod +x ${D}/usr/bin/openrex-isp-handler.sh
}

FILES_${PN} = " \
	/home/root/lpc/* \
	/usr/bin/* \
"
