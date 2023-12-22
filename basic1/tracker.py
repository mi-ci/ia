import requests
from bs4 import BeautifulSoup

Name = input("소환사명을 입력하세요: ")
SummonerName = ""
Ranking = ""
TierUnranked = ""
LeagueType = []
Tier = []
LP = []
Wins = []
Losses = []
Ratio = []

url='https://www.op.gg/summoner/userName=' + Name
hdr = {'Accept-Language': 'ko_KR,en;q=0.8', 'User-Agent': ('Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Mobile Safari/537.36')}
req = requests.get(url, headers=hdr)
html = req.text
soup = BeautifulSoup(html, 'html.parser')
# print(soup)

# 소환사 이름 크롤링
for i in soup.select('meta'):
    SummonerName = i.text
print(SummonerName)

# # 랭킹 크롤링
# for i in soup.select('span[class=ranking]'):
#     Ranking = i.text

# # 언랭 판별용 티어 크롤링
# TierUnranked = soup.select('div.Cell')

# # 리그 타입 크롤링
# for i in soup.select('div[class=LeagueType]'):
#     LeagueType.append(i.text)

# # 티어 크롤링
# for i in soup.select('div[class=Tier]'):
#     Tier.append(i.text)

# # 리그 포인트 크롤링
# for i in soup.select('div[class=LP]'):
#     LP.append(i.text)

# # 승리 패배 판수 크롤링
# for i in soup.select('span[class=Wins]'):
#     Wins.append(i.text)

# for i in soup.select('span[class=Losses]'):
#     Losses.append(i.text)

# # 승률 크롤링
# for i in soup.select('span[class=Ratio]'):
#     Ratio.append(i.text)

# if SummonerName != "":
#     check = input(SummonerName + "님의 솔로랭크 정보가 궁금하시면 '솔랭'을, 자유랭크 정보가 궁금하시면 '자랭'을 입력해주세요: ")
#     if check == '솔랭':
#         if 'Unranked' in str(TierUnranked[0]):
#             print("==================================")
#             print(SummonerName + "님은 솔로랭크 Unranked입니다.")
#             print("==================================")
#         else:
#             print("==================================")
#             print(SummonerName + "님의 솔로랭크 정보입니다.")
#             print("==================================")
#             print("티어: " + Tier[0].strip('\n\t'))
#             print("LP: " + LP[0])
#             print("승/패: " + Wins[0] + " " + Losses[0])
#             print("승률: " + Ratio[0])

#     elif check == '자랭':
#         if 'Unranked' in str(TierUnranked[1]):
#             print("==================================")
#             print(SummonerName + "님은 자유랭크 Unranked입니다.")
#             print("==================================")
#         else:
#             print("=====================================")
#             print(SummonerName + "님의 자유랭크 정보입니다.")
#             print("=====================================")
#             print("티어: " + Tier[1].strip('\n\t'))
#             print("LP: " + LP[1])
#             print("승/패: " + Wins[1] + " " + Losses[1])
#             print("승률: " + Ratio[1])

#     else:
#         print("Error! 정확하게 입력해주세요.")
# else:
#     print("소환사 정보가 없습니다.")
