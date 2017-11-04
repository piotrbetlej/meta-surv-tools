#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Nodejs file manager application"
SECTION = "Surv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/piotrbetlej/node-file-manager.git;branch=node-file-manager-jpeg-gallery-preview;protocol=https"
SRC_URI += "file://npm_pm2.patch"
SRCREV="${AUTOREV}"

DEPENDS="nodejs glibc"
REDEPENDS_${PN}="nodejs glibc"
PREFERRED_VERSION_nodejs="0.12.15"

FILES_${PN} += "${sbindir}/node-file-manager"

S = "${WORKDIR}/git"

inherit npm-install

do_install_append () {
	install -d ${D}/${sbindir}/node-file-manager
	cp -prf ${S}/* ${D}${sbindir}/node-file-manager
	chown -R root:root ${D}${sbindir}/node-file-manager
}
