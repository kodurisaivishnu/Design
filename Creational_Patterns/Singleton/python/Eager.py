# this is the Eager way where we are only get a single instance when we call

#Note:python has the same Eager and Lazy
class Singleton:
  _instance = None

  def __init__(self):
    if Singleton._instance is None:
      Singleton._instance = self
    else:
      raise Exception("instance is already there")

  @classmethod
  def get_instance(cls):
    if cls._instance is None:
      cls._instance = Singleton()
    return cls._instance


ob1 = Singleton.get_instance()
ob2 = Singleton.get_instance()
# Singleton() # it will raise the error
print(ob1 is ob2)
