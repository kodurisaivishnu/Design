
class LazySingleton:
  _instance = None

  def __init__(self):
    if LazySingleton._instance is not None:
      raise Exception("Alredy Existed Instance Don't create a new one")
    LazySingleton._instance = self
  
  @classmethod
  def get_instance(cls):
    if cls._instance is None:
      cls._instance = LazySingleton()
    return cls._instance

ob1 = LazySingleton.get_instance()
ob2 = LazySingleton.get_instance()

print(ob1 is ob2)