package com.callor.word.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.youngjin.standard.MenuService;
import com.youngjin.standard.impl.MenuServiceImplV1;

public class WordService {

	protected Random rnd;
	protected List<WordVO> wordList;
	protected Scanner scan;
	protected MenuService menuService;

	protected int nScore;
	protected int nCount;

	public WordService() {

		rnd = new Random();
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);

		this.read();

		//dd
	}

	public void selectMenu() {
		// TODO 메뉴 출력하기

		while (true) {

			List<String> menuList = new ArrayList<String>();

			menuList.add("🍉게임시작🍉");
			menuList.add("🍓저장하기🍓");
			menuList.add("🍈불러오기🍈");

			menuService = new MenuServiceImplV1("💰🎩괴도뤼팡의 보물찾기🎩💰", menuList);
			Integer intMenu = menuService.selectMenu();

			if (intMenu == null) {
				System.out.println("Game Over ❗❗❗");
				break;
			}
			if (intMenu == 1) {
				this.input();
			} else if (intMenu == 2) {
				this.save();
			} else if (intMenu == 3) {
				this.load();
			}

		}
	}

	public String[] suffle(String strEng) {
		// TODO vo.getEng() 단어의 문자들을 나눠 배열로 만들고 섞기

		String[] strWord = strEng.split("");

		for (int i = 0; i < 50; i++) {

			int num1 = rnd.nextInt(strWord.length);
			int num2 = rnd.nextInt(strWord.length);

			String temp = strWord[num1];
			strWord[num1] = strWord[num2];
			strWord[num2] = temp;

		}
		return strWord;

	} // end suffle

	public void save() {
		// TODO 플레이했던 점수 저장하기

		String fileName = null;
		FileWriter fileWriter;
		PrintWriter out;

		while (true) {
			System.out.println("저장할 파일 이름을 입력하세요");
			System.out.print(">> ");
			fileName = scan.nextLine();
			if (fileName.equals("")) {
				System.out.println("파일 이름은 반드시 입력하세요");
				continue;
			}

			break;
		}

		String strFileName = "src/com/callor/word/" + fileName + ".txt";

		try {
			fileWriter = new FileWriter(strFileName);
			out = new PrintWriter(fileWriter);

			out.print(nScore);

			out.flush();
			out.close();

			System.out.println("저장 완료");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load() {
		// TODO save()에서 저장한 파일을 불러오기

		while (true) {

			String fileName = null;
			FileReader fileReader;
			BufferedReader buffer;

			while (true) {
				System.out.println("불러올 파일 이름을 입력하세요");
				System.out.print(">> ");
				fileName = scan.nextLine();
				if (fileName.equals("")) {
					System.out.println("파일 이름을 제대로 입력해주세요");
					continue;
				}
				break;
			}

			String strFileName = "src/com/callor/word/" + fileName + ".txt";

			try {
				fileReader = new FileReader(strFileName);
				buffer = new BufferedReader(fileReader);

				String reader = buffer.readLine();
				nScore = Integer.valueOf(reader);

				buffer.close();

				System.out.println("불러온 점수 : " + nScore);
				System.out.println("불러오기 완료");
				
				break;

			} catch (FileNotFoundException e) {
				System.out.println("없는 파일입니다");
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void dd() {

	}

	public void inputMenu(String[] strWord, WordVO vo) {

		while (true) {

			System.out.println("=".repeat(80));
			System.out.println("\t" + "👉👉 제시된 영단어를 바르게 배열하세요(QUIT:종료) 👈👈");
			System.out.println("\t" + "👉👉‍         힌트(1점이 차감됩니다) : H           👈👈");
			System.out.println("\t" + vo.toString());
			System.out.println("\t" + "\t" + Arrays.toString(strWord));
			System.out.println("=".repeat(80));
			System.out.print(">> ");
			String strInput = scan.nextLine();
			if (strInput.equals("H")) {
				if (nScore == 0) {
					System.out.println("\t" + "점수가 부족합니다!!");
					continue;
				}
				System.out.println(vo.getKor());
				nScore--;
				continue;
			}
			if (strInput.equals("QUIT")) {
				System.out.println("\t" + "메뉴로 돌아갑니다");
				return;
			}
			if (strInput.equals(vo.getEng())) {
				System.out.println("\t" + "✨✨정답입니다✨✨");
				nScore++;
				System.out.println("\t" + "현재 점수 : " + nScore);
				break;
			} else {
				System.out.println("\t" + "🎃🎃오답입니다🎃🎃");
				Integer odap = this.odap(nScore, nCount);
				if (odap == 1) {
					nCount++;
					System.out.println("\t" + "현재 재도전 횟수 : " + nCount);
					nScore--;
					continue;
				} else if (odap == 2) {
					nScore--;
					break;
				} else if (odap == 4) {
					return;
				} else if (odap == 3) {
					if (nScore == 0) {
						System.out.println("\t" + "점수가 부족합니다!!");
						continue;
					}
					System.out.println(vo.getKor());
					nScore--;
					continue;
				}
			}
			break;
		}

	}

	public void input() {
		// TODO 게임플레이하기

		while (true) {

			WordVO vo = this.getWord();
			String strEng = vo.getEng();

			String[] strWord = this.suffle(strEng);

			this.inputMenu(strWord, vo);
			return;

		}
	}

	public Integer odap(int nScore, int nCount) {

		// Input()에서 오답이었을 경우를 처리하는 method

		while (true) {
			System.out.println("-".repeat(80));
			System.out.println("1. 재도전 (3번 재도전이 가능하며 1점이 차감됩니다)");
			System.out.println("2. 건너뛰기 (1점이 차감됩니다)");
			System.out.println("3. 힌트보기 (1점이 차감됩니다)");
			System.out.println("4. 그만하기");

			System.out.println("-".repeat(80));
			System.out.print(">> ");
			String st = scan.nextLine();
			if (st.equals("1")) {
				if (nCount == 3) {
					System.out.println("\t" + "재도전 횟수를 초과하였습니다");
					continue;
				}
				if (nScore <= 0) {
					System.out.println("\t" + "점수가 부족합니다");
					continue;
				}
				return 1;
			} else if (st.equals("2")) {
				if (nScore <= 0) {
					System.out.println("\t" + "점수가 부족합니다");
					continue;
				}
				return 2;
			} else if (st.equals("3")) {
				return 3;

			} else if (st.equals("4")) {
				System.out.println("\t" + "메뉴로 돌아갑니다");
				return 4;
			} else {
				System.out.println("1,2,3,4 만 입력하세요!");
				continue;
			}

		}

	}

	public void read() {
		// TODO 영단어가 들어있는 파일을 읽어들이기

		String fileName = "src/com/callor/word/word.txt";

		FileReader fileReader;
		BufferedReader buffer;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				String str[] = reader.split(":");

				WordVO vo = new WordVO();
				vo.setEng(str[0]);
				vo.setKor(str[1]);
				wordList.add(vo);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WordVO getWord() {

		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);

		WordVO vo = wordList.get(num);

//		System.out.println(vo.toString());

		return vo;
	}

}
