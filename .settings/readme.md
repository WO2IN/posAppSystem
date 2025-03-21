# 전기차 전처리 통합 모듈
```bash
├── ev_keywords.json # EV 데이터 필드명 키워드
├── ev_preprocessing.py # Betterwhy 데이터 관련 모듈 정의
└── readme.md
```
#### [**공통 작업**](#common_tasks)
#### [**통합 EV 전처리 작업**](#ev_preprocessing)
<br>

## 📌 공통 작업 모듈 설명
<a id="common_tasks"></a>

### **✔️ to_seconds**

✅ **기능**
- **문자열 형태의 날짜/시간을 Epoch(유닉스 시간)으로 변환**
<br><br> 

🔹 **입력값**
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `date_str` | `String` | 변환할 날짜 및 시간 문자열 |
<br>

🔹 **출력값**
| 반환값 | 타입 | 설명 |
|-|-|-|
| `date_obj.timestamp()` | `float` |변환된 Epoch(유닉스 시간) |
<br> 

---

### **✔️ set_outliers_to_nan**

✅ **기능**
- **규격에 맞게 이상치 값 NaN값으로 처리**
<br><br> 

🔹 **입력값**
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 이상치를 NaN으로 변환할 데이터프레임 |
| `column_ranges` | `dict` | 각 컬럼별 허용하는 최소/최대값 범위를 정의한 딕셔너리 |
<br>

🔹 **출력값**
| 반환값 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` |이상치가 NaN으로 변경된 데이터프레임 |
| `target_tot_rows` | `int` |처리한 전체 데이터 개수 |
| `valid_count` | `dict` |컬럼별 정상값(이상치 제외 후 남은 값) 개수 |
| `nan_count` | `dict` | 컬럼별 이상치(변환된 NaN) 개수 |
<br>

---
### **✔️ save_outliers_meta**

✅ **기능**
- **파일의 메타 정보를 JSON 형식으로 MinIO에 저장**
<br><br> 

🔹 **입력값**
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 컬럼을 추출할 데이터프레임 |
| `keys_to_extract` | `list` | 추출할 키워드 리스트 |
<br>

🔹 **출력값**
| 반환값 | 타입 | 설명 |
|-|-|-|
| `column_map` | `dict` | 각 키워드에 해당하는 컬럼명을 매핑한 딕셔너리 |
<br>

---
### **✔️ generate_column_names_from_pattern**

✅ **기능**
- **컬럼의 숫자 범위를 자동으로 찾아서 생성하는 함수**
<br><br> 

🔹 **입력값**
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 	컬럼명을 검사할 데이터프레임 |
| `column_name` | `String` | 숫자 패턴을 포함할 가능성이 있는 컬럼명 |
<br>

🔹 **출력값**
| 반환값 | 타입 | 설명 |
|-|-|-|
| `list` | `list` | 자동으로 생성된 컬럼명 리스트 |
<br>

---

<br>

## 📌 통합 EV 전처리 작업 설명
<a id="ev_preprocessing"></a>

## **충전/방전 구간 분류**
### **✔️ get_slow_charge_list ・ get_fast_charge_list ・ get_discharge_list**

✅ **기능**
- 각 함수는 **충/방전 구간을 분류**하고, **해당 구간들을 리스트 형태로 반환**
- 각 구간은 **충전 상태**(`chg_state`)에 따라 **필터링**되며, **SOC 변화량과 시간 차이로 구분됨**
<br><br> 

🔹 **입력값**
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 구간을 추출할 데이터 |
<br>

🔹 **출력값**
| 반환값 | 타입 | 설명 |
|-|-|-|
| `{TYPE}_charge_list` | `List[pd.DataFrame]` | `{TYPE}`에 해당하는 구간이 포함된 데이터프레임들의 리스트 |
<br> 

---

<a id="section_statistics"></a>

## **구간 데이터 통계 추출**
### ✔️ **section_statistics**

✅ **기능**
- 주어진 데이터프레임에서 **차량 구간별 통계 값을 추출**하여 **데이터프레임 형태로 반환**
- `차량 정보`, `충전/방전 구간`, `전력량`, `SOC 변화량`, `주행거리`, `전비`, `온도`, `충전 속도` 등 다양한 지표를 계산하여 반환
<br><br> 

🔹 **입력값**
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 구간 통계를 계산할 데이터 |
| `csv_file` | `String` | 파일 경로, 충전/방전 타입을 결정하는데 사용 |

⚠️ 파일 경로에 **충전/방전** 타입이 포함되거나 `charge_type` 필드가 있어야 함.
<br><br>

🔹 **출력값**
| 반환값 | 타입 | 설명 |
|-|-|-|
| `df`    | `pd.DataFrame` | 각 구간에 대한 다양한 통계 정보가 포함된 데이터프레임 |
| `nan_cnt` | `int`        | 데이터 규격에 벗어난 데이터 개수               |
<br> 

---

## 📌 ev_preprocessing 모듈 사용 방법
**1. 필수 라이브러리 설치**
```python
pip install pandas
pip install numpy
```
**2. BetterwhyData 선언**
```python
from Betterwhy_Data.BetterwhyData import *
```
**3. BetterwhyData 활용**
```python
# 원본 데이터 전처리
df = origin_preprocessing(df)

# 충전/방전 구간 분류 
df[] = get_discharge_list(df) # 방전구간 분류

df[] = get_slow_charge_list(df) # 완속구간 분류

df[] = get_fast_charge_list(df) # 급속구간 분류

# 구간 데이터 통계 추출
df = section_statistics(df, csv_path)
```

<br>

## 📌 사용 예시
```python
import pandas
import numpy 

from Betterwhy_Data.BetterwhyData import *

def main():
    # csv_list = (CSV 파일 목록 가져오기 (MinIO 또는 Local))

    for csv_file in csv_list:
        df = pd.read_csv(csv_file)

        # 원본 데이터 전처리 (df(pd.DataFrame) --> df(pd.DataFrame))
        origin_preproc = origin_preprocessing(df)

        # 충전/방전 구간 분류 (df(pd.DataFrame) --> List[])
        for discharging_df in get_discharge_list(df): # 방전구간 분류 
            print(discharging_df)

        for fast_charging_df in get_fast_charge_list(df): # 급속구간 분류
            print(fast_charging_df)

        for slow_charging_df in get_slow_charge_list(df): # 완속구간 분류
            print(slow_charging_df)
        
        # 구간 데이터 통계 추출 (df(pd.DataFrame), csv_path(String) --> df(pd.DataFrame))
        section_df = section_statistics(df, csv_path)

if __name__ == "__main__":
    main()
```
