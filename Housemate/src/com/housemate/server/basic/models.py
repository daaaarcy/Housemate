from django.db import models

class User(models.Model):
    user_id = models.EmailField(primary_key=True, max_length=254)
    first_name = models.CharField(max_length=50)
    last_name = models.CharField(max_length=50)
    #image = models.ImageField()

    def __unicode__(self):
        return self.user_id
    
class Household(models.Model):
    size = models.IntegerField()
    residents = models.ManyToManyField('User')

    def __unicode__(self):
        return self.id

class Owe(models.Model):
    borrower = models.ForeignKey('User', related_name='borrower')
    lender = models.ForeignKey('User', related_name='lender')
    datetime = models.DateTimeField(auto_now=True)
    amount = models.DecimalField(default=0, max_digits=10, decimal_places=2)
    title = models.CharField(default='Untitled', max_length=100)
    desc = models.TextField(blank=True)
    is_pending = models.BooleanField(default=False)

    def __unicode__(self):
        return self.id
