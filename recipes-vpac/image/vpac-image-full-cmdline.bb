DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed."

IMAGE_FEATURES += " \
	splash ssh-server-openssh \
	package-management \
	tools-debug tools-profile tools-sdk tools-testapps debug-tweaks \
	hwcodecs \
"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-core-buildessential \
    packagegroup-core-device-devel \
    packagegroup-core-full-cmdline \
    packagegroup-core-sdk \
    packagegroup-core-ssh-openssh \
    packagegroup-core-tools-debug \
    packagegroup-core-tools-profile \
    packagegroup-core-tools-testapps \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    kernel-dev \
    kernel-modules \
    openssh-sftp-server \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

inherit core-image

IMAGE_ROOTFS_EXTRA_SPACE_append += "+ 500000" 
