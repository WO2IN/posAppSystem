# Betterwhy Data
```bash
├── Main.py # Betterwhy 모듈 테스트 파일
├── BetterwhyData.py # Betterwhy 데이터 관련 모듈 정의
└── readme.md
```
#### [**1차 데이터 전처리 설명**](#first_processing)
#### [**충/방전 구간 분류 설명**](#classify_charging)

## 📌 BetterwhyData 모듈 설명
<a id="first_processing"></a>
### ➖ `first_processing()`

#### ✅ 기능
- 차량 데이터 (`df`)를 입력받아 `clientid`를 기준으로 `betterwhy_cartype_list.csv`의 정보를 매칭  
- `car_type`, `model_year`, `model_month` 필드 추가  
- 이상값 (`SOC`, `SOH`, `전류`, `온도`)은 `NaN`으로 변환  

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 차량 데이터 (`clientid` 필드 포함) |

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 차종 정보 추가 및 이상값이 처리된 데이터 |

---

<a id="classify_charging"></a>
### ➖ `get_slow_charge_list`, `get_fast_charge_list`, `get_discharge_list`

#### ✅ 기능
- 각 함수는 **충/방전 구간**을 분류하고, 해당 구간들을 **리스트 형태로 반환**
- 각 구간은 **충전 상태**(`chg_state`) 에 따라 필터링되고, `SOC` 변화량과 시간 차이를 기준으로 구분 
- 급속 충전은 `fast_chg_current` 필드, 완속 충전은 `slow_chg_current` 필드를 기준으로, 방전 구간은 **충전 상태**(`chg_state`) 가 0일 때, SOC 변화량과 시간 차이만으로 구분

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 구간을 추출할 데이터 |

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `{type}_charge_list` | `List[pd.DataFrame]` | `{type}`에 해당하는 구간이 포함된 데이터프레임들의 리스트 |



## 📝 진행사항
#### ✅ 완료된 작업
-  충/방전 구간 분류 모듈화 **(2025.01.24)**
-  구간 데이터 통계 추출 모듈화 **(2025.01.24)**
-  1차 전처리 모듈화 **(2025.02.10)**
-  최종 전처리 모듈화 **(2025.02.11)**
  
#### ⏳ 진행 중
- README 작성 중 . . .

