#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SECTION = "surv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "svn://svn.code.sf.net/p/mp3splt/code/mp3splt-project/;module=trunk;rev=1524;protocol=https"
# svn checkout https://svn.code.sf.net/p/mp3splt/code/mp3splt-project/trunk mp3splt-code

S = "${WORKDIR}/trunk"

DEPENDS = "gettext gettext-native libtool"
RDEPENDS_${PN} = "gettext gettext-native"

inherit cmake