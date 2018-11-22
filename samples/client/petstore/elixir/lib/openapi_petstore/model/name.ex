# NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
# https://openapi-generator.tech
# Do not edit the class manually.

defmodule OpenapiPetstore.Model.Name do
  @moduledoc """
  Model for testing model name same as property name
  """

  @derive [Poison.Encoder]
  defstruct [
    :"name",
    :"snake_case",
    :"property",
    :"123Number"
  ]

  @type t :: %__MODULE__{
    :"name" => integer(),
    :"snake_case" => integer(),
    :"property" => String.t,
    :"123Number" => integer()
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.Name do
  def decode(value, _options) do
    value
  end
end

