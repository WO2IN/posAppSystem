# 📘 전기차 데이터 전처리 LLM 프로젝트

## 📁 프로젝트 소개

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

## ⚙️ 설치 및 실행 방법

## 📈 전처리 결과 예시

![image](https://github.com/WO2IN/ev_assets/blob/main/preprocessing_result.png)
