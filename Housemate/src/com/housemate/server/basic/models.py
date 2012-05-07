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
    """
    mate_0 = models.ForeignKey('User', related_name='mate_0')
    mate_1 = models.ForeignKey('User', related_name='mate_1',
            null=True, on_delete=models.SET_NULL)
    mate_2 = models.ForeignKey('User', related_name='mate_2',
            null=True, on_delete=models.SET_NULL)
    #mate_4 = models.ForeignKey('User')
    #mate_5 = models.ForeignKey('User')
    #mate_6 = models.ForeignKey('User')
    #mate_7 = models.ForeignKey('User')
    #mate_8 = models.ForeignKey('User')
    #mate_9 = models.ForeignKey('User')
    #mate_10 = models.ForeignKey('User')
    """
    def __unicode__(self):
        return self.id

class Owe(models.Model):
    borrower_id = models.ForeignKey('User', related_name='borrower')
    lender_id = models.ForeignKey('User', related_name='lender')
    datetime = models.DateTimeField(auto_now=True)
    amount = models.DecimalField(max_digits=10, decimal_places=2)
    title = models.CharField(max_length=100)
    desc = models.TextField(blank=True)

    def __unicode__(self):
        return self.id
