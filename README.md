# meta-fsl-arm-voipac
Freescale Yocto Project Community BSP

# Getting the BSP

To get the BSP you need to have `repo` installed and use it as:

## Install the `repo` utility:
    mkdir ~/workdir/bin
    curl http://commondatastorage.googleapis.com/git-repo-downloads/repo  > ~/workdir/bin/repo
    chmod a+x ~/workdir/bin/repo
    PATH=${PATH}:~/workdir/bin

## Download the BSP Yocto Project Environment
    mkdir -pv ~/workdir/imx6/yocto/fsl-release-bsp
    cd ~/workdir/imx6/yocto/fsl-release-bsp
    repo init -u git://git.freescale.com/imx/fsl-arm-yocto-bsp.git -b imx-4.1-krogoth

## Add tinyrex support  
    mkdir -pv .repo/local_manifests/
    cat > .repo/local_manifests/imx6tinyrex.xml << EOF
    <?xml version="1.0" encoding="UTF-8"?>
    <manifest>
    
      <remote fetch="git://github.com/Voipac" name="voipac"/>
    
      <project remote="voipac" revision="master" name="meta-fsl-arm-voipac" path="sources/meta-fsl-arm-voipac">
        <copyfile src="voipac-setup.sh" dest="voipac-setup.sh"/>
      </project>
    </manifest>
    EOF

## Sync repositories
    repo sync

## Add Voipac meta layer into BSP
    source voipac-setup.sh

# Building images
    cd ~/workdir/imx6/yocto/fsl-release-bsp

## Supported machines <machine name>
    imx6-openrexbasic
    imx6-openrexmax
    imx6-openrexultra
    imx6-rexbasic
    imx6-rexpro
    imx6-rexultra
    imx6-tinyrexlite
    imx6-tinyrexbasic
    imx6-tinyrexpro
    imx6-tinyrexmax
    imx6-tinyrexmax4g
    imx6-tinyrexultra

## Supported distros <distro name>
	fsl-imx-x11
	fsl-imx-wayland
	fsl-imx-xwayland
	fsl-imx-fb

## Setup and Build Console image
    MACHINE=<machine name> source setup-environment build-dir
    MACHINE=<machine name> bitbake core-image-base

## Setup and Build Toolchain    
    MACHINE=<machine name> bitbake core-image-base -c populate_sdk
    
## Setup and Build FSL GUI image
    DISTRO=<distro name> MACHINE=<machine name> source fsl-setup-release.sh -b build-x11
    DISTRO=<distro name> MACHINE=<machine name> bitbake fsl-image-gui

