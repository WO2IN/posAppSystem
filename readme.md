# 원본 데이터 전처리 
<br>

## ✅ 주요 기능  
- **차종 관련 필드 생성 및 값 부여**
  - `car_type`: 차종 정보 생성
  - `model_year`: 제조 연도 추가
  - `model_month`: 제조 월 추가  
  - `오류 값 처리`: NaN 값으로 변경

<br>

## 🛠 주요 파일 설명
- #### **betterwhy_cartype_list.csv**
  - `client_id`를 기준으로 차량의 `car_type`, `model_year`, `model_month` 정보를 제공하는 CSV 파일

<br>

## 🔧 주요 함수 설명
- #### **BetterwhyData.py** 함수
  - **origin_preprocessing** : **차종 관련 필드 생성** 및 규격 설정 후 **set_outliers_to_nan()** 함수 호출출
    - 인자값 : **df**(`pd.DataFrame`)
    - 반환값 : **df**(`pd.DataFrame`), **nan_cnt**(`int`)
    
  <br>

  - **set_outliers_to_nan()** : 설정한 규격과 데이터를 받아서 규격에 넘는 데이터를 `NaN`값으로 처리
    - 인자값 : **df**(`pd.DataFrame`), **column_ranges**(`dict`)
    - 반환값 : **df**(`pd.DataFrame`), **nan_cnt**(`int`)

<br>

## 🌐 샘플 데이터 입력 / 출력 경로
| 데이터 종류 | 데이터 입력 위치 | 데이터 저장 위치 |
|-|-|-|
|Sample (`Local`)|ev_process/betterwhy/data_files/sample/sample_origin|ev_process/betterwhy/data_files/test
|Sample (`MinIO`)|`betterwhy-ev-tmp`/sample/sample_origin|`betterwhy-ev-tmp`/

<br>

## 📝  실행 결과  
```python
>>==============================================================
1. 전처리 완료된 파일 수: 51
2. 전처리된 데이터 라인 수: 3,453,953
3. NaN 값으로 변경된 개수: 27,576
4. 총 실행 시간: 447.84778 sec
----------------------------------------------------------------
원본 데이터 전처리 완료. 데이터 저장을 완료했습니다.
==============================================================<<
```
