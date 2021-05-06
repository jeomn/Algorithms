#20210507
#해시


from collections import defaultdict


def solution(genres, plays):
    answer = []
    
    music_dict, genres_dict = defaultdict(list), defaultdict(int)
    for idx in range(len(genres)):
        music_dict[genres[idx]].append((idx, plays[idx]))
        genres_dict[genres[idx]] += plays[idx]
    
    for genre, g_play in sorted(genres_dict.items(), key=lambda x: x[1], reverse=True):
        count = 0
        for p_idx in sorted(music_dict[genre], key=lambda x: x[1], reverse=True):
            if count == 2:
                break
            answer.append(p_idx[0])
            count += 1

    return answer
