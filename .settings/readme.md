# 📘 전기차 데이터 전처리 LLM 프로젝트

<br>

## 🧾 프로젝트 소개
#### 전기차 데이터 전처리 LLM 프로젝트는 전기차에서 수집된 다양한 데이터를 자동으로 전처리하고, 이를 LLM(Large Language Model)을 활용해 질의응답 및 분석에 활용할 수 있도록 구성된 백엔드 시스템입니다.  
#### 사용자 요청에 따라 데이터를 처리하며, Open-WebUI 기반의 인터페이스를 통해 자연어로 손쉽게 결과를 확인할 수 있도록 설계되었습니다.  
#### 또한, 이 시스템은 다양한 데이터 소스와의 연동이 가능하며, 유연한 함수 매핑 구조를 통해 전처리 로직을 손쉽게 확장할 수 있습니다.

<br>

- ### 🔍 주요 기능

    - #### 전기차 데이터에 대한 자동 전처리 파이프라인

    - #### 사용자 요청 기반의 유연한 함수 매핑 및 처리

    - #### LLM 연동을 통한 자연어 기반 질의 응답

<br>

## 📂 디렉토리 구조 
```
KETI_LLM/
├── backend/                          # 백엔드 관련 코드 디렉토리
│   ├── api/                          # API 서버 관련 코드
│   │   └── main.py                   # FastAPI 등 메인 엔트리포인트
│
│   ├── config/                       # 설정 파일 및 매핑 정보
│   │   ├── betterwhy_cartype_list.csv   
│   │   ├── ev_function_mapping.json     
│   │   ├── ev_keywords.json             
│   │   └── path_info.ini                
│
│   ├── core/                         # 핵심 로직 및 처리 모듈
│   │   ├── format.py                 
│   │   └── llama.py                  # LLM 관련 처리 모듈
│
│   ├── data/                         # 데이터 처리 관련 모듈
│   │   ├── ev_preprocessing.py  
│   │   ├── processor.py             
│   │   └── MinioData.py              
│
├── open-webui/                       # Open-WebUI 폴더
├── README.md                         
└── requirements.txt                  # 프로젝트 의존 패키지 목록
```

<br>

## ⚙️ 설치 및 실행 방법
- ### 1️⃣ 시흥 GPU2 서버 접속
    ``` bash
    ssh woo_1n@keti-ev1.iptime.org -p 2005 
    PW: keti1234!
    ```
- ### 2️⃣ Open-WebUI 및 FastAPI 실행
    ```bash
    # Open-WebUI 실행

    $ cd /home/woo_1n/betterwhy_data/KETI_LLM/open-webui
    $ docker compose up -d

    # FastAPI 실행

    $ cd /home/woo_1n/betterwhy_data/KETI_LLM
    $ uvicorn backend.api.main:app --host 0.0.0.0 --port 8001 --reload
    ```
- ### 3️⃣ Open-WebUI 접속
    - #### URL : http://localhost:3000/
    - #### Email : keti@keti.re.kr
    - #### `ID` : KETI / `PW` : keti1234!
    
## 📈 전처리 결과 예시

![image](https://github.com/WO2IN/ev_assets/blob/main/preprocessing_result.png)


<br>

 ## 📝 작업 예정
- #### 🔜 출력 포맷 추가 (현재 구간 데이터 통계만 완성됨)
- #### MinIO 경로 설정 모듈 추가 예정 (`processor.py > process_instruction` 함수 내 직접 수정 중)
- #### 웹 검색 기능 추가 예정 (LangChain 사용 고려 중)

<br>

- ### 🧠 LLM 자연어 해석 정확도 개선 방안 검토 중
