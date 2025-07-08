# Database Schema

## Overview

The `AlertRule` entity represents an alerting rule with a name, a Spring Expression Language (SpEL) condition, lists of alerters and notifiers, and an enabled flag.

### Tables

#### 1. `alert_rules`

| Column           | Data Type       | Description                                      |
|------------------|-----------------|------------------------------------------------|
| `id`             | Integer (auto-generated, primary key) | Unique identifier for each alert rule.          |
| `name`           | String (variable length) | Name of the alert rule.                          |
| `spel_condition` | String (text)   | Condition expression in Spring Expression Language (SpEL). |
| `enabled`        | Boolean         | Flag indicating if the alert rule is active.   |

#### 2. `alert_rule_alerters`

| Column           | Data Type       | Description                                     |
|------------------|-----------------|------------------------------------------------|
| `alert_rule_id`  | Integer         | Foreign key referencing `alert_rules(id)`.     |
| `alerter`        | String (variable length) | Name or identifier of an alerter linked to the alert rule. |

- Stores the list of alerters associated with an alert rule.
- Multiple alerters can be linked to a single alert rule.

#### 3. `alert_rule_notifiers`

| Column           | Data Type       | Description                                     |
|------------------|-----------------|------------------------------------------------|
| `alert_rule_id`  | Integer         | Foreign key referencing `alert_rules(id)`.     |
| `notifier`       | String (variable length) | Name or identifier of a notifier linked to the alert rule. |

- Stores the list of notifiers associated with an alert rule.
- Multiple notifiers can be linked to a single alert rule.
