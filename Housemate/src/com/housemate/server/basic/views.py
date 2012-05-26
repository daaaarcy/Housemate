from basic.models import User, Household, Owe
from django.http import HttpResponse
from django.db.models import Q
from django.shortcuts import render_to_response
import logging
import json

logger = logging.getLogger("housemate.db")

#def getProfileEntries(request, user_id, start_date, end_date, or more)
def get_profile_entries(request, user_id):
    # query the database and get all the lends/borrows with user_id
    user = User.objects.get(pk=user_id)
    owes = Owe.objects.filter(Q(borrower=user) |
            Q(lender=user)).select_related(depth=1).values('borrower_id',
                    'borrower__first_name', 'borrower__last_name', 'lender_id',
                    'lender__first_name', 'lender__last_name', 'title', 'desc',
                    'is_pending', 'datetime', 'amount')
    context_helper = {'owe_list': owes, 'my_id': user_id}
    return render_to_response('profile.json', context_helper)

def test(request):
    return HttpResponse("YEAHHHHHHHH!")

