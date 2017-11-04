#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SECTION = "surv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/Motion-Project/motion.git;protocol=https;rev=master \
"
SRC_REV = "${AUTOREV}"

DEPENDS = "jpeg ffmpeg"
RDEPENDS_${PN} = "jpeg ffmpeg"

inherit autotools pkgconfig gettext

# SVNDIR = "${WORKDIR}/build"
ORIG = "${WORKDIR}/git"
S = "${ORIG}"
B = "${ORIG}"


#do_install () {
#	mkdir -p ${D}/${libdir}
#	install ${B}/src/.libs/libmp3splt.so.0.0.9 ${D}/${libdir}
#	cp -a ${B}/src/.libs/libmp3splt.so.0 ${D}/${libdir}
#	cp -a ${B}/src/.libs/libmp3splt.so ${D}/${libdir}
#
#	install ${B}/plugins/.libs/libsplt_mp3.so.0.0.0 ${D}/${libdir}
#	cp -a ${B}/plugins/.libs/libsplt_mp3.so.0 ${D}/${libdir}
#	cp -a ${B}/plugins/.libs/libsplt_mp3.so ${D}/${libdir}
#
#}
