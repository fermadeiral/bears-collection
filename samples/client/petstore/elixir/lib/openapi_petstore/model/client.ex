# NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
# https://openapi-generator.tech
# Do not edit the class manually.

defmodule OpenapiPetstore.Model.Client do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :"client"
  ]

  @type t :: %__MODULE__{
    :"client" => String.t
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.Client do
  def decode(value, _options) do
    value
  end
end

