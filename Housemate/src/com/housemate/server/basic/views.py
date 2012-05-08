from basic.models import User, Household, Owe
from django.http import HttpResponse
from django.core import serializers
from django.db.models import Count, Q
import logging

logger = logging.getLogger("housemate.db")

#def getProfileEntries(request, user_id, start_date, end_date, or more)
def getProfileEntries(request, user_id):
    # query the database and get all the lends/borrows with user_id
    """
    user = User.objects.filter(user_id=user_id)
    count = user.count()
    if (count == 0):
        return HttpResponseBadRequest("%s is not registered." % user_id)
    """
    user = User.objects.get(pk=user_id)
    owes = Owe.objects.filter(Q(borrower=user) | Q(lender=user))
    json_serializer = serializers.get_serializer("json")()
    entries = json_serializer.serialize(owes, ensure_ascii=False)
    return HttpResponse(entries)

def test(request):
    return HttpResponse("YEAHHHHHHHH!")

