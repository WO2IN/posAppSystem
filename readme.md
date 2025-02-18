# 급속, 완속, 방전 구간 분류
<br>

## 🔧 주요 함수 설명
- #### **BetterwhyData.py** 함수
  - **get_discharge_list()** : `방전구간`을 담은 데이터프레임 `리스트 반환` 함수
  - **get_fast_charge_list()** : `급속구간`을 담은 데이터프레임 `리스트 반환` 함수
  - **get_slow_charge_list()** : `완속구간`을 담은 데이터프레임 `리스트 반환` 함수
  - **charge_upload()** : `충전/방전구간`을 MinIO / Local에 `업로드`하는 함수

<br>

## ✅ 주요 기능
- **공통 필드**  
  - `timestamp`: 데이터 수집 시간  
  - `soc`: 배터리 잔량 상태
  - `chg_state`: 충전 상태를 나타내는 코드 **(0: 커넥터 연결 X / 1: 커넥터 연결 O)**

- 완속 충전 구간  
  - `slow_chg_current`:완속충전기 결속 시 최대 전류량

- 급속 충전 구간  
  - `fast_chg_current`: 급속충전기 결속 시 최대 전류량

- 분류 방법  
  - 위 데이터 필드와 SOC 변화량과 시간 차이로 `급속`, `완속`, `방전` 구간으로 분류

<br>

## 🌐 데이터 입력 / 출력 경로
| 데이터 종류 | 데이터 입력 위치 | 데이터 저장 위치 |
|-|-|-|
|Betterwhy(Local)|$ rsync -avhz -e 'ssh -p 9990' --progress --partial data@59.14.241.229:/home/data/hdd_new/betterwhy_data/betterwhy_preproc 저장위치<br>[pw : evdataset1234!]| /
|Betterwhy(MinIO)|keti-ev-data/betterwhy_data/betterwhy_preprocessed|tmp/classify_charging

<br><br>

## 📝 실행 결과
```python
>>==============================================================
1. 전처리 완료된 파일 수: 51
2. 전처리된 데이터 라인 수: 2,991,490
3. 총 실행 시간: 508.11575 sec
----------------------------------------------------------------
급속, 완속, 방전 구간 추출 완료. 데이터 저장을 완료했습니다.
==============================================================<<
```
