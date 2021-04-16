package com.callor.word.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public WordService() {

		rnd = new Random();
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);

		this.read();

	}

	public void selectMenu() {

		while (true) {

			List<String> menuList = new ArrayList<String>();

			menuList.add("게임시작");
			menuList.add("저장하기");
			menuList.add("불러오기");

			menuService = new MenuServiceImplV1("괴도뤼팡", menuList);

			Integer intMenu = menuService.selectMenu();
			if (intMenu == null) {
				System.out.println("Game Over !");
				break;
			}
			if (intMenu == 1) {
				this.input();
			} else if (intMenu == 2) {

			} else if (intMenu == 3) {

			}

		}
	}

	public String[] suffle(String strEng) {

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
		
		
		
	}
	
	public void input() {

		int nScore = 0;

		while (true) {
			
			WordVO vo = this.getWord();
			String strEng = vo.getEng();

			String[] strWord = this.suffle(strEng);

			int nCount = 0;

			while (true) {

				
				System.out.println("=".repeat(80));
				System.out.println("== 제시된 영단어를 바르게 배열하세요(QUIT:종료) ==");
				System.out.println("= 기회는 3번입니다 =");
				System.out.println(vo.toString());
				System.out.println(Arrays.toString(strWord));
				System.out.println("=".repeat(80));
				System.out.print(">> ");
				String strInput = scan.nextLine();
				if (strInput.equals("QUIT")) {
					System.out.println("메뉴로 돌아갑니다");
					return;
				}
				if (strInput.equals(vo.getEng())) {
					System.out.println("정답입니다");
					nScore++;
					System.out.println("현재 점수 : " + nScore);
					break;
				} else {
					System.out.println("오답입니다");
					Integer odap = this.odap(nScore);
					if (odap == 1) {
						nScore--;
						continue;
					} else if (odap == 2) {
						nScore--;
						break;
					} else if (odap == 3) {
						return;
					} else if (odap == null) {
						break;
					}
				}
			}
		}
	}

	

	public Integer odap(int nScore) {

		while (true) {
			System.out.println("-".repeat(80));
			System.out.println("1. 재도전 (1점이 차감됩니다)");
			System.out.println("2. 건너뛰기 (1점이 차감됩니다)");
			System.out.println("3. 그만하기");
			System.out.println("-".repeat(80));
			System.out.print(">> ");
			String st = scan.nextLine();
			if (st.equals("1")) {
				if (nScore <= 0) {
					System.out.println("점수가 부족합니다");
					continue;
				}
				return 1;
			} else if (st.equals("2")) {
				if (nScore <= 0) {
					System.out.println("점수가 부족합니다");
					continue;
				}
				return 2;
			} else if (st.equals("3")) {
				System.out.println("메뉴로 돌아갑니다");
				return 3;
			} else {
				System.out.println("1,2,3 만 입력하세요!");
				return null;
			}

		}

	}

	public void read() {

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
