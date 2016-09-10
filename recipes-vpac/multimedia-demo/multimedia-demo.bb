SUMMARY = "Multimedia files"
DESCRIPTION = "Various audio/video files."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = " \
	file://trailer_480p.mov \
	file://video-playback \
	file://video-playback.desktop \
"

S = "${WORKDIR}"

do_install() {
	mkdir -p ${D}/home/root/multimedia/
	cp ${S}/trailer_480p.mov ${D}/home/root/multimedia/
	mkdir -p ${D}/usr/bin/
	mkdir -p ${D}/usr/share/applications/
	cp ${S}/video-playback ${D}/usr/bin/
	cp ${S}/video-playback.desktop ${D}/usr/share/applications/
	chmod +x ${D}/usr/bin/video-playback
}

FILES_${PN} = " \
	/home/root/multimedia/* \
	/usr/bin/* \
	/usr/share/applications/* \
"
