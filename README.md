ngrinder-siteminder-sso
=======================

ngrinder-siteminder-sso is the ngrinder plugin which allows users who passed siteminder served in a web server (like apache httpd) to login to ngrinder without additional login.

## How to build
* Install atlassian framework framework(aka APF) and set up followings.
** export M2_HOME=APF_INSTALLATION_PATH/apache-maven
** export PATH=APP_INSTALLATION_PATH/bin:${PATH}
* clone the git repo.
** git clone https://github.com/nhnopensource/ngrinder-siteminder-sso.git
* build the plugin
** atlas-package
* copy the packaged plugin to ${NGRINDER_HOME}/plugins/

## How to configure 
* Open the system configuration editor in ngrinder
* Provide following configurations.
'''
ngrinder.sso.header.id=id_field_name_in_header_siteminder_provide
ngrinder.sso.header.name=name_field_name_in_header_siteminder_provide
ngrinder.sso.header.email=email_field_name_in_header_siteminder_provide
ngrinder.sso.header.cellphone=cellphone_field_name_in_header_siteminder_provide
ngrinder.sso.header.locale=locale_field_name_in_header_siteminder_provide
ngrinder.sso.header.timezone=timezone_field_name_in_header_siteminder_provide
ngrinder.sso.default.locale=default_locale_if_no_locale_is_provided
ngrinder.sso.default.timezone=default_timezone_if_no_timezone_is_provided
ngrinder.sso.domain=the_domain_name_of_ngrinder
ngrinder.sso.cookiename=the_cookiename_name_of_ngrinder
'''
** This completly depends on the your siteminder configuration, please ask to your siteminder administrator.

## How to 
