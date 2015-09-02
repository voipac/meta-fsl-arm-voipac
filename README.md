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
    repo init -u git://git.freescale.com/imx/fsl-arm-yocto-bsp.git -b imx-3.14.28-1.0.1_patch

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
    imx6s-tinyrex
    imx6q-tinyrex
    
## Setup and Build for Console image
    MACHINE=<machine name> source setup-environment build-dir
    MACHINE=<machine name> bitbake core-image-base

## Setup and Build for X11
    MACHINE=<machine name> source fsl-setup-release.sh -b build-x11 -e x11

## Setup and Build for FB 
    MACHINE=<machine name> source fsl-setup-release.sh -b build-fb -e fb

## Setup and Build for Wayland 
    MACHINE=<machine name> source fsl-setup-release.sh -b build-wayland -e wayland

## Setup and Build for DirectFB
    MACHINE=<machine name> source fsl-setup-release.sh -b build-dfb -e dfb
    
        
    
