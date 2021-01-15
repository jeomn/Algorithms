#Summer/Winter Coding(~2018)
def solution(skill, skill_trees):
    answer = len(skill_trees)
    
    #개발사 스킬트리 하나씩 확인
    for i in range(1, len(skill)):
        s = skill[i]
        #유저 스킬트리 확인
        for j in skill_trees:
            user_skill = j
            user_skill_token = ''
            #개발사 스킬이 유저스킬에 있을 때
            if s in user_skill:
                #유저스킬의 개발사스킬부터 앞쪽 리스트를 token에 넣는다
                sindex = user_skill.index(s)
                user_skill_token = user_skill[:sindex]
                if skill[i-1] not in user_skill_token:
                    skill_trees[skill_trees.index(j)] = str(-1)
                    answer-=1
        while '-1' in skill_trees:
            skill_trees.remove('-1')
        
    return answer
