ngrinder-siteminder-sso
=======================

ngrinder-siteminder-sso is the ngrinder plugin which allows users who passed siteminder served in a web server (like apache httpd) to login to ngrinder without additional login.


How to build
============
* Install atlassian framework framework(aka APF) and set up followings.
** export M2_HOME=APF_INSTALLATION_PATH/apache-maven
** export PATH=APP_INSTALLATION_PATH/bin:${PATH}
* clone the git repo.
** git clone https://github.com/nhnopensource/ngrinder-siteminder-sso.git
* build the plugin
** atlas-package
* copy the packaged plugin to ${NGRINDER_HOME}/plugins/

How to configure 
================
