# 🚗 Betterwhy Data
```bash
├── Main.py # Betterwhy 모듈 테스트 파일
├── BetterwhyData.py # Betterwhy 데이터 관련 모듈 정의
└── readme.md
```

## 📌 BetterwhyData 모듈 설명

### **🔹1차 데이터 전처리** (`first_processing`)

#### ✅ 기능
- 차량 데이터(`df`)를 입력받아 `clientid`를 기준으로 `betterwhy_cartype_list.csv`의 정보를 매칭
- 차종(`car_type`), 모델 연도(`model_year`), 모델 월(`model_month`) 필드 추가
- 정상 범위를 벗어난 값(`SOC`, `SOH`, `전류`, `온도` 등)은 `NaN`으로 변환

#### 🔹 **입력값**
- `df` `(pd.DataFrame)`: 차량 데이터가 포함된 데이터프레임<br>　　　　　　　　 
                     `clientid` 필드를 포함해야 하며, 이를 기준으로 차종 정보를 매칭

#### 🔹 **출력값**
- `pd.DataFrame`: 
  - 차종(`car_type`), 모델 연도(`model_year`), 모델 월(`model_month`) 필드가 추가된 데이터프레임
  - 이상값(`SOC`, `SOH`, `전류`, `온도` 등)이 `NaN`으로 처리됨.

## 📝 진행사항
#### ✅ 완료된 작업
-  충/방전 구간 분류 모듈화 **(2025.01.24)**
-  구간 데이터 통계 추출 모듈화 **(2025.01.24)**
-  1차 전처리 모듈화 **(2025.02.10)**
-  최종 전처리 모듈화 **(2025.02.11)**
  
#### ⏳ 진행 중
- README 작성 중 . . .
