# Building Process

## First we will install the required host packages for Ubuntu as detailed in the quickstart, i.e.

	sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm nano

## Add some other packages which will be needed for the walk-through below.

	sudo apt-get install autoconf libtool rpm

## Build a baseline image

After configuring the environment you will be left in the build_qemux86 folder.
You should then build a baseline image, which will take some time (numbers of hours)

	bitbake core-image-minimal


## Show Bitbake Layers

	bitbake-layers show-recipes

## JDL versions

- https://linux.enea.com/2.0/sources/git2/www.jdl.com.software.dtc.git/
- https://linux.enea.com/3.0/sources/git2/www.jdl.com.software.dtc.git/
- https://linux.enea.com/4.0/sources/git2/www.jdl.com.software.dtc.git/
