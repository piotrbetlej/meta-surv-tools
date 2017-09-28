#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SECTION = "surv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "svn://svn.code.sf.net/p/mp3splt/code/mp3splt-project/branches;module=mp3splt-project_0.9.2__2.6.2;protocol=https;rev=1505 \
file://001-disable-cutter-and-test-dir.patch \
file://eliminate-test-dir.patch \
file://tolerate-warnings.patch \
file://bugfix-libmad-include-host-poisioning.patch \
"

# svn checkout https://svn.code.sf.net/p/mp3splt/code/mp3splt-project/trunk mp3splt-code
# https://svn.code.sf.net/p/mp3splt/code/mp3splt-project/branches/mp3splt-project_0.9.2__2.6.2

DEPENDS = "gettext gettext-native libtool libpcre libmad flac"
RDEPENDS_${PN} = "gettext libpcre libmad flac"

FILES_${PN} += "${nonarch_libdir}/pkgconfig ${libdir}/libmp3splt0/libsplt_mp3.l* ${libdir}/libmp3splt0/libsplt_flac.l* ${libdir}/libmp3splt0/libsplt_mp3.so.* ${libdir}/libmp3splt0/libsplt_flac.so.*"
FILES_${PN}-dev += "${libdir}/libmp3splt0/libsplt_mp3.so ${libdir}/libmp3splt0/libsplt_flac.so"

PACKAGES="${PN} ${PN}-dbg ${PN}-staticdev ${PN}-dev ${PN}-doc ${PN}-locale"

inherit autotools pkgconfig gettext

# SVNDIR = "${WORKDIR}/build"
ORIG = "${WORKDIR}/mp3splt-project_0.9.2__2.6.2/libmp3splt"
S = "${ORIG}"
B = "${ORIG}"

EXTRA_OECONF = "--disable-id3tag --disable-ogg"

do_configure_prepend() {
	mkdir -p ${S}/libltdl/config
	touch ${S}/libltdl/config/config.rpath
}

do_install () {
	mkdir -p ${D}${libdir}
	install ${B}/src/.libs/libmp3splt.so.0.0.9 ${D}${libdir}
	cp -a ${B}/src/.libs/libmp3splt.so.0 ${D}${libdir}
	cp -a ${B}/src/.libs/libmp3splt.so ${D}${libdir}

	mkdir -p ${D}${libdir}/libmp3splt0
	install ${B}/plugins/.libs/libsplt_mp3.so.0.0.0 ${D}${libdir}/libmp3splt0
	cp -a ${B}/plugins/.libs/libsplt_mp3.so.0 ${D}${libdir}/libmp3splt0
	cp -a ${B}/plugins/.libs/libsplt_mp3.so ${D}${libdir}/libmp3splt0
	cp -a ${B}/plugins/.libs/libsplt_mp3.l* ${D}${libdir}/libmp3splt0

	install ${B}/plugins/.libs/libsplt_flac.so.0.0.0 ${D}${libdir}/libmp3splt0
	cp -a ${B}/plugins/.libs/libsplt_flac.so.0 ${D}${libdir}/libmp3splt0
	cp -a ${B}/plugins/.libs/libsplt_flac.so ${D}${libdir}/libmp3splt0
	cp -a ${B}/plugins/.libs/libsplt_flac.l* ${D}${libdir}/libmp3splt0

	mkdir -p ${D}${nonarch_libdir}/pkgconfig
	install ${B}/libmp3splt.pc ${D}${nonarch_libdir}/pkgconfig

	mkdir -p ${D}${prefix}/include/libmp3splt
	install ${B}/include/libmp3splt/* ${D}/${prefix}/include/libmp3splt/
}
