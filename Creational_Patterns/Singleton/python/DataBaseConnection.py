import threading
class DataBaseConnection:
  _instance = None
  _lock = threading.Lock()

  def __init__(self):
    if DataBaseConnection._instance is not None:
      raise Exception("Instance Exited")
    DataBaseConnection._instance = self

  @classmethod
  def get_instance(cls):
    if cls._instance is None:
      with cls._lock:
        if cls._instance is None:
          cls._instance = DataBaseConnection()
    return cls._instance
  
  def query(self,sql : str):
    print("excuting query...",sql)


ob1 = DataBaseConnection.get_instance()
ob2  = DataBaseConnection.get_instance()

print(ob1 is ob2)

ob1.query("select * from table")