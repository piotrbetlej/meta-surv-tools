#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SECTION = "surv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "svn://svn.code.sf.net/p/mp3splt/code/mp3splt-project/branches;module=mp3splt-project_0.9.2__2.6.2;protocol=https;rev=1505"
# svn checkout https://svn.code.sf.net/p/mp3splt/code/mp3splt-project/trunk mp3splt-code
# https://svn.code.sf.net/p/mp3splt/code/mp3splt-project/branches/mp3splt-project_0.9.2__2.6.2

DEPENDS = "gettext gettext-native libtool libpcre"
RDEPENDS_${PN} = "gettext gettext-native libpcre"

inherit autotools pkgconfig gettext

# SVNDIR = "${WORKDIR}/build"
ORIG = "${WORKDIR}/mp3splt-project_0.9.2__2.6.2/libmp3splt"
S = "${WORKDIR}/build"

EXTRA_OECONF = "--disable-ogg --disable-flac --disable-id3tag --disable-mp3"

do_configure_prepend() {
    cp -rpf ${ORIG}/* ${S}
    mkdir -p ${S}/libltdl/config
    touch ${S}/libltdl/config/config.rpath
}


#do_configure() {
#     ${S}/autogen.sh
#}
