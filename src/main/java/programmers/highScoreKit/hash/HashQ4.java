package programmers.highScoreKit.hash;

import java.util.*;

// 베스트 앨범
public class HashQ4 {

    public static void main(String[] args) {

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        int[] answer = solution(genres, plays);
        // return [4, 1, 3, 0]
        for(int ans : answer) {
            System.out.println(ans);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        List<Music> musics = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            musics.add(new Music(genres[i], plays[i], i));
        }

        Collections.sort(musics);

        Map<String, PlayList> map = new HashMap<>();

        for (Music music : musics) {
            PlayList playList = map.getOrDefault(music.genre, new PlayList());
            playList.addMusic(music);

            map.put(music.genre, playList);
        }

        List<PlayList> playLists = new ArrayList<>();

        int arraySize = 0;
        for (String key : map.keySet()) {
            playLists.add(map.get(key));

            if(map.get(key).musicList.size() > 2) {
                arraySize += 2;
            } else {
                arraySize += map.get(key).musicList.size();
            }
        }
        Collections.sort(playLists);

        int[] answer = new int[arraySize];

        int index = 0;
        for (PlayList playList : playLists) {
            for (int i = 0; i < playList.musicList.size(); i++) {
                answer[index] = playList.musicList.get(i).id;
                index++;

                if(i == 1) {
                    break;
                }
            }
        }


        return answer;

    }

    static class PlayList implements Comparable<PlayList> {
        public List<Music> musicList = new ArrayList<>();
        public int totalPlay = 0;

        public void addMusic(Music music) {
            this.musicList.add(music);
            this.totalPlay += music.play;
        }

        @Override
        public String toString() {
            return "PlayList{" +
                    "musicList=" + musicList +
                    ", totalPlay=" + totalPlay +
                    '}';
        }

        @Override
        public int compareTo(PlayList playList) {
            if(this.totalPlay < playList.totalPlay) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static class Music implements Comparable<Music> {
        public String genre;
        public int play;
        public int id;

        public Music(String genre, int play, int id) {
            this.genre = genre;
            this.play = play;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "genre='" + genre + '\'' +
                    ", play=" + play +
                    ", id=" + id +
                    '}';
        }

        @Override
        public int compareTo(Music music) {
            if (this.play < music.play) {
                return 1;
            } else if (this.play == music.play) {
                if(this.id < music.id) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        }
    }

}
