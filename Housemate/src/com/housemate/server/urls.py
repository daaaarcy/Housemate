from django.conf.urls.defaults import patterns, include, url

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'housemate.views.home', name='home'),
    url(r'test', 'basic.views.test'),
    url(r'^profile/(?P<user_id>[\w._%+-]+@\w+(?:\.[A-Za-z]{2,4})+)$',
        'basic.views.getProfileEntries'),

    # url(r'^housemate/', include('housemate.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    # url(r'^admin/', include(admin.site.urls)),
)
