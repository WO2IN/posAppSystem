# Betterwhy Data
```bash
├── Main.py # Betterwhy 모듈 테스트 파일
├── BetterwhyData.py # Betterwhy 데이터 관련 모듈 정의
└── readme.md
```
#### [**1차 데이터 전처리 설명**](#first_processing)
#### [**충/방전 구간 분류 설명**](#classify_charging)

## 📌 BetterwhyData 모듈 설명
### 🔹 **first_processing()**
<a id="first_processing"></a>

#### ✅ 기능
- 차량 데이터(`df`)를 입력받아 `clientid`를 기준으로 `betterwhy_cartype_list.csv`의 정보를 매칭
- 차종(`car_type`), 모델 연도(`model_year`), 모델 월(`model_month`) 필드 추가
- 정상 범위를 벗어난 값(`SOC`, `SOH`, `전류`, `온도` 등)은 `NaN`으로 변환

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df`| `pd.DataFrame`|차량 데이터 (clientid 필드 포함)|

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `df`| `pd.DataFrame`|차종 정보 추가 및 이상값이 처리된 데이터프레임|

### 🔹**get_****_charge_list**
<a id="classify_charging"></a>

#### ✅ 기능
- 
-
-

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df`| `pd.DataFrame`|구간을 추출할 데이터프레임|

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `****_charge_list`| `List`|유효한 구간 데이터프레임을 담고있는 리스트|

## 📝 진행사항
#### ✅ 완료된 작업
-  충/방전 구간 분류 모듈화 **(2025.01.24)**
-  구간 데이터 통계 추출 모듈화 **(2025.01.24)**
-  1차 전처리 모듈화 **(2025.02.10)**
-  최종 전처리 모듈화 **(2025.02.11)**
  
#### ⏳ 진행 중
- README 작성 중 . . .
