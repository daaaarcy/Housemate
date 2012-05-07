from basic.models import User, Household, Owe
from django.http import HttpResponse

#def getProfileEntries(request, user_id, start_date, end_date, or more)
def getProfileEntries(request, user_id):
    # query the database and get all the lends/borrows w.r.t user_id
    return HttpResponse("%s" % user_id)

def test(request):
    return HttpResponse("YEAHHHHHHHH!")

