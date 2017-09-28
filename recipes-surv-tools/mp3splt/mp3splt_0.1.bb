#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SECTION = "surv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "svn://svn.code.sf.net/p/mp3splt/code/mp3splt-project/branches;module=mp3splt-project_0.9.2__2.6.2;protocol=https;rev=1505 \
"
DEPENDS = "libmp3splt"
RDEPENDS_${PN} = "libmp3splt"

inherit autotools pkgconfig gettext

# SVNDIR = "${WORKDIR}/build"
ORIG = "${WORKDIR}/mp3splt-project_0.9.2__2.6.2/newmp3splt"
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
