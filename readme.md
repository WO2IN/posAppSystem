# 📘 전기차 데이터 전처리 LLM 프로젝트

<br>

```mermaid
graph LR

A1[사용자 입력 - Open WebUI] --> A2[입력 해석 LLM - 분기 판단]

A2 -->|일반 채팅| B1[일반 챗 LLM]
B1 --> B2[응답 생성 - GPT 방식]
B2 --> B3[출력 - Open WebUI]

A2 -->|EV 전처리 요청| C1[전처리 LLM - 명령 해석 및 매핑]
C1 --> C2[함수 실행 - FastAPI / processor.py]
C2 --> C3[결과 반환 - JSON]
C3 --> C4[출력 - Open WebUI]

```

## 🧾 프로젝트 소개
#### 전기차에서 수집된 다양한 데이터를 자동으로 전처리하고, 이를 LLM(Large Language Model)을 활용해 질의응답 및 분석에 활용할 수 있도록 구성된 백엔드 시스템 
#### 사용자 요청에 따라 데이터를 처리하며, Open-WebUI 기반의 인터페이스를 통해 자연어로 손쉽게 결과를 확인할 수 있도록 설계되어있음 
#### 또한, 이 시스템은 다양한 데이터 소스와의 연동이 가능하며, 유연한 함수 매핑 구조를 통해 전처리 로직을 손쉽게 확장 가능

<br>

- ### 🔍 주요 기능

    - #### 전기차 데이터에 대한 자동 전처리 파이프라인

    - #### 사용자 요청 기반의 유연한 함수 매핑 및 처리

    - #### LLM 연동을 통한 자연어 기반 질의 응답

<br>

## 📂 디렉토리 구조 
```
KETI_LLM/
├── backend/                         
│   ├── api/    
│   │   ├── dockerfile                # FastAPI docker 설정
│   │   ├── requirements.txt          # 프로젝트 의존 패키지 목록                      
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
│   │   ├── processor.py              # LLM 지시 기반 함수 실행 모듈
│   │   └── llama.py                  # LLM 관련 처리 모듈
│
│   ├── data/                         # 데이터 처리 관련 모듈
│   │   ├── ev_preprocessing.py       # 전기차 전처리 모듈
│   │   └── MinioData.py              
│
├── open-webui/                       # Open-WebUI 폴더
└── README.md                         
```

<br>


## 🖥️ 서버 사양 
 - #### 시흥 GPU2 서버 : `keti-ev1.iptime.org -p 2005`
    - #### `CPU` : Ryzen7960x (24C 48T)
    - #### `RAM` : 128GB
    - #### `NVMe` : 1TB
    - #### `PSU` : 2000W
    - #### `GPU` 
        - #### RTX 4090 (24GB)
        - #### RTX 3080 (10GB)

<br>

## 🧠 LLM 모델 
 - #### LLM Model : `Llama 3.3 : 70B` (42GB) 
 - #### LLM Model 실행 할 경우 GPU 2장 모두 메모리 `85 ~ 90%` 사용

<br>

## ⚙️ 실행 방법
- ### ⭐ Open-WebUI 접속
    - #### `URL` : http://keti-ev1.iptime.org:3333/
    - #### `Email` : keti@keti.re.kr
    - #### `PW` : keti1234!
    
<br>

## 📈 전처리 결과 예시

![image](https://github.com/WO2IN/ev_assets/blob/main/preprocessing_result.png)


<br>

 ## 📝 작업 예정
- #### 🔜 LangChain 사용
- #### Open-WebUI 함수기능 추가
- #### 전처리 모듈 추가 및 수정
